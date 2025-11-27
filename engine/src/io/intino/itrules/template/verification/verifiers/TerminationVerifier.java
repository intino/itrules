package io.intino.itrules.template.verification.verifiers;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.verification.VerificationException;

import java.util.*;

public class TerminationVerifier implements Verifier<Frame> {
	public boolean verify(Frame frame) throws VerificationException {
		return isAcyclic(graphOf(frame));
	}

	private Map<Frame, List<Frame>> graphOf(Frame root) throws VerificationException {
		try {
			Map<Frame, List<Frame>> graph = new HashMap<>();
			Deque<Frame> stack = new ArrayDeque<>(List.of(root));
			while (!stack.isEmpty()) {
				Frame current = stack.pop();
				if (graph.containsKey(current)) continue;
				List<Frame> deps = dependenciesOf(current);
				graph.put(current, deps);
				for (Frame dep : deps) {
					if (!graph.containsKey(dep)) {
						stack.push(dep);
					}
				}
			}
			return graph;
		} catch (Throwable e) {
			throw new VerificationException(e.getMessage());
		}
	}

	private List<Frame> dependenciesOf(Frame frame) {
		if (frame instanceof FrameBuilder.Composite c) return c.slots().values().stream()
				.flatMap(Collection::stream)
				.filter(f -> f instanceof FrameBuilder.Composite)
				.toList();
		return List.of();
	}

	private boolean isAcyclic(Map<Frame, List<Frame>> graph) {
		Map<Frame, Integer> indegree = new HashMap<>();
		graph.keySet().forEach(v -> {
			indegree.putIfAbsent(v, 0);
			graph.get(v).forEach(w -> indegree.merge(w, 1, Integer::sum));
		});
		Deque<Frame> queue = new ArrayDeque<>();
		for (Map.Entry<Frame, Integer> e : indegree.entrySet()) if (e.getValue() == 0) queue.add(e.getKey());

		int visited = 0;
		while (!queue.isEmpty()) {
			Frame v = queue.remove();
			visited++;
			List<Frame> neighbors = graph.getOrDefault(v, List.of());
			neighbors.forEach(w -> {
				int d = indegree.get(w) - 1;
				indegree.put(w, d);
				if (d == 0) queue.add(w);
			});
		}
		return visited == indegree.size();
	}
}

#!/bin/bash
if [[ "$1" == "-h" || "$1" == "--help" || "$#" -ne 3 ]]; then
  echo "Usage: ./run-itrules.sh <template.itr> <json_string> <output.txt>"
  echo
  echo "Arguments:"
  echo "  <template.itr>   ITRules template file."
  echo "  <json_string>    JSON string with input data (must be quoted)."
  echo "  <output.txt>     Path to the output file."
  echo
  echo "Example:"
  echo "  ./run-itrules.sh template.itr '{\"name\":\"Alice\"}' result.txt"
  echo
  exit 1
fi

TEMPLATE_FILE="$1"
JSON_STRING="$2"
OUTPUT_FILE="$3"

# You may need to adjust the path to the JAR file below
JAR_FILE="$HOME/.m2/repository/io/intino/itrules/itrules-cli/2.0.3/itrules-cli-2.0.3.jar"

java -jar "$JAR_FILE" "$TEMPLATE_FILE" "$JSON_STRING" "$OUTPUT_FILE"
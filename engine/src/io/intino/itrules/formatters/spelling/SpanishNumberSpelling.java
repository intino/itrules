/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.formatters.spelling;

import io.intino.itrules.formatters.NumberFormatters;

public class SpanishNumberSpelling implements NumberFormatters.NumberSpelling {
	private static final String[] numbers = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve", "veinte"};
	private static final String[] multipleOfTenNumbers = {"", "", "", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
	private static final String[] hundreds = {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};

	@Override
	public String spell(int number) {
		return number > 0 ? readLessThanOneBillion(number) : "cero";
	}

	private String readLessThanOneBillion(int number) {
		return trim(readMillions(number / 1000000) + " " + readLessThanOneMillion(number % 1000000));
	}

	private String readMillions(int number) {
		return number > 1 ? readLessThanOneMillion(number) + " millones" : number == 1 ? "un millón" : "";
	}

	private String readLessThanOneMillion(int number) {
		return trim(readThousands(number / 1000) + " " + readLessThanOneThousand(number % 1000));
	}

	private String readThousands(int number) {
		return number > 1 ? readLessThanOneThousand(number) + " mil" : number == 1 ? "mil" : "";
	}

	private String readLessThanOneThousand(int number) {
		return number != 100 ? trim(readHundreds(number / 100) + " " + readLessThanOneHundred(number % 100)) : "cien";
	}

	private String readHundreds(int number) {
		return hundreds[number];
	}

	private String readLessThanOneHundred(int number) {
		return number <= 20 ? readLessThanTwenty(number) : number < 30 ? readLestThanThirty(number) : readMultipleOfTen(number) + (number % 10 == 0 ? "" : " y " + readLessThanTwenty(number % 10));
	}

	private String readLestThanThirty(int number) {
		return "veinti" + readLessThanTwenty(number % 10);
	}

	private String readMultipleOfTen(int number) {
		return multipleOfTenNumbers[number / 10];
	}

	private String readLessThanTwenty(int number) {
		return numbers[number];
	}

	private String trim(String text) {
		return text.trim();
	}
}

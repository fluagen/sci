package com.sci.app.toolkit;

import java.util.Vector;

public class Language {

	private static final String[] languages = { 
			"All languages", "English",
			"Afrikaans", "Arabic", "Basque", "Belarusian", "Bengali",
			"Bulgarian", "Catalan", "Chinese", "Croatian", "Czech", "Danish",
			"Dutch", "Estonian", "Finnish", "Flemish", "French", "Gaelic",
			"Galician", "Georgian", "German", "Greek", "Hebrew", "Hungarian",
			"Icelandic", "Italian", "Japanese", "Korean", "Latin", "Latvian",
			"Lithuanian", "Macedonian", "Malay", "Multiple Languages",
			"Norwegian", "Persian", "Polish", "Portuguese", "Provencal",
			"Romanian", "Russian", "Serbian", "Serbo-Croatian", "Slovak",
			"Slovenian", "Spanish", "Swedish", "Thai", "Turkish", "Ukrainian",
			"Welsh"
	};

	public static String[] getLanguages() {
		return languages;
	}
}

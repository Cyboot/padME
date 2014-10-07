package de.timweb.padme.util;

import java.io.File;
import java.lang.reflect.Field;

public class Init {
	private static boolean	libraryInit	= false;

	/**
	 * set the library path (dll & Co)
	 */
	public static void setLibraryPath() {
		if (libraryInit)
			return;

		// Source:
		// http://blog.cedarsoft.com/2010/11/setting-java-library-path-programmatically/
		final String JAVA_LIBRARY_PATH = "java.library.path";

		String libPath = System.getProperty(JAVA_LIBRARY_PATH) + ";"
				+ new File("src/main/resources").getAbsolutePath();
		System.setProperty(JAVA_LIBRARY_PATH, libPath);

		try {
			Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
			fieldSysPath.setAccessible(true);
			fieldSysPath.set(null, null);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load Java Library Path.", e);
		}
		libraryInit = true;
	}

	public static void useDirectInputPlugin() {
		System.setProperty("jinput.useDefaultPlugin", "false");
		System.setProperty("jinput.plugins", "net.java.games.input.DirectInputEnvironmentPlugin");

	}
}

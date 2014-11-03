package com.NuclearHolocaust.NuclearHolocaust.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.NuclearHolocaust.NuclearHolocaust.NuclearHolocaust;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Nuclear holocaust";
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cfg.height=screenSize.height;
		cfg.width=screenSize.width;
		cfg.fullscreen = true;
		new LwjglApplication(new NuclearHolocaust(), cfg);
	}
}

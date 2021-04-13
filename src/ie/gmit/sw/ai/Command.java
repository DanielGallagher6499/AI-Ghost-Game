package ie.gmit.sw.ai;

/*	Daniel Gallagher - G00360986
 * 	Artificial intelligence project
 */

/*
 * Use implementations of this functional interface to specify
 * how a computer controlled game character should behave.
 */

@FunctionalInterface
public interface Command {
	public void execute();
}
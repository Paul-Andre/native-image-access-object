This is a minimal example of how you can create Java objects and expose references to them in C, when compiling your Java into a Graal Native Image.

The trick is to use ObjectHandle and ObjectHandles

package task4;

@FunctionalInterface
interface RunnableThrows {
    void run() throws Exception;

    static void wrapThrows(RunnableThrows runnable) {
        try {
            runnable.run();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

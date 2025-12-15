class ExternalLogger {
    public void logMessage(String msg) {
        System.out.println("External log: " + msg);
    }
}

interface Logger {
    void log(String message);
}

class LoggerAdapter implements Logger {
    private ExternalLogger externalLogger;

    public LoggerAdapter(ExternalLogger externalLogger) {
        this.externalLogger = externalLogger;
    }

    public void log(String message) {
        externalLogger.logMessage(message);
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        Logger logger = new LoggerAdapter(new ExternalLogger());
        logger.log("Hello Adapter");
    }
}

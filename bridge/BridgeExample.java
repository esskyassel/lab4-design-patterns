interface Device {
    void print(String data);
}

class Monitor implements Device {
    public void print(String data) {
        System.out.println("Monitor: " + data);
    }
}

class Printer implements Device {
    public void print(String data) {
        System.out.println("Printer: " + data);
    }
}

abstract class Output {
    protected Device device;

    public Output(Device device) {
        this.device = device;
    }

    public abstract void render(String data);
}

class TextOutput extends Output {
    public TextOutput(Device device) {
        super(device);
    }

    public void render(String data) {
        device.print("Text -> " + data);
    }
}

class ImageOutput extends Output {
    public ImageOutput(Device device) {
        super(device);
    }

    public void render(String data) {
        device.print("Image -> " + data);
    }
}

public class BridgeExample {
    public static void main(String[] args) {
        Device monitor = new Monitor();
        Device printer = new Printer();

        Output textOnMonitor = new TextOutput(monitor);
        Output textOnPrinter = new TextOutput(printer);

        textOnMonitor.render("Hello");
        textOnPrinter.render("Hello");

        Output imageOnMonitor = new ImageOutput(monitor);
        imageOnMonitor.render("101010");
    }
}

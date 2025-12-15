enum RequestType {
    TYPE_A, TYPE_B
}

class Request {
    private RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }
}

interface Handler {
    void setNextHandler(Handler next);
    void handleRequest(Request request);
}

class HandlerA implements Handler {
    private Handler next;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE_A) {
            System.out.println("HandlerA handled request");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

class HandlerB implements Handler {
    private Handler next;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE_B) {
            System.out.println("HandlerB handled request");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

public class ChainExample {
    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();

        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest(new Request(RequestType.TYPE_A));
        handlerA.handleRequest(new Request(RequestType.TYPE_B));
    }
}

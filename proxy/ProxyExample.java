interface Database {
    void query(String sql);
}

class RealDatabase implements Database {
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

class DatabaseProxy implements Database {
    private RealDatabase database = new RealDatabase();
    private boolean hasAccess;

    public DatabaseProxy(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    public void query(String sql) {
        if (hasAccess) {
            database.query(sql);
        } else {
            System.out.println("Access denied");
        }
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Database userDb = new DatabaseProxy(false);
        Database adminDb = new DatabaseProxy(true);

        userDb.query("SELECT * FROM users");
        adminDb.query("SELECT * FROM users");
    }
}

package me.hakki.nat_project.objects;

import me.hakki.nat_project.api.databases.IDatabaseHandler;
import me.hakki.nat_project.databases.MongoHandler;

public enum DatabaseType {
    MONGODB(new MongoHandler());

    private IDatabaseHandler handler;

    DatabaseType(IDatabaseHandler dbHandler) {
        this.handler = dbHandler;
    }

    public IDatabaseHandler getHandler() {
        return handler;
    }
}

package com.crimelab.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

public final class TilesConfig implements DefinitionsFactory {
 
    private static final Map<String, Definition> tilesDefinitions = new HashMap<>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/tiles/layouts/layout.jsp");

    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/WEB-INF/tiles/templates/header.jsp"));
        //attributes.put("menu", new Attribute("/WEB-INF/views/layout/menu.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/tiles/templates/footer.jsp"));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    public static void addDefinitions(){
        addDefaultLayoutDef("*", "Home", "/WEB-INF/views/{1}.jsp");
        addDefaultLayoutDef("*/*", "Home", "/WEB-INF/views/{1}/{2}.jsp");
    }

}

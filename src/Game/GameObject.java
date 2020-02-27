package Game;

import Game.Physics.BoxCollider;
import Game.Renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // quan li doi tuong (static)
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }

    public static void clearAll() {
        gameObjects.clear();
    }

    public static <E> E findIntersects(Class<E> cls, BoxCollider hitbox) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active
                    && cls.isAssignableFrom(object.getClass())
                    && object.hitBox != null
                    && object.hitBox.intersect(hitbox)) {
                return (E) object;
            }
        }
        return null;
    }

    // dinh nghia doi tuong
//    public BufferedImage image; // null
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public BoxCollider hitBox;

    public GameObject() {
        gameObjects.add(this);
        position = new Vector2D(); //(0, 0)
        velocity = new Vector2D(); //(0, 0)
        active = true;
    }

    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, this);
        }
    }

    public void run() {
        position.add(velocity.x, velocity.y);
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }

    public static <E> E find(Class<E> cls) {
        try {
            return cls.getConstructor().newInstance();
        } catch (Exception ex) {
            return null;
        }
    }
}
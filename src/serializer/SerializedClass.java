package serializer;

import java.util.ArrayList;

public abstract class SerializedClass<T> {

    public abstract String buildObjectJson();

    public String listedObjects(ArrayList<SerializedClass<T>> objs) {
        if (objs == null || objs.size() == 0)
            return "[]";
        StringBuilder out = new StringBuilder("[");
        int length = objs.size();
        for (int i = 0; i < length; i++) {
            out.append(objs.get(i).buildObjectJson());
            if (i != length - 1)
                out.append(",");
        }
        out.append("]");
        return out.toString();
    }
}

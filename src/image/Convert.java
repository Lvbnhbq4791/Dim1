package image;

import java.util.Objects;

public class Convert implements TexConver {
    public TexColorSchema schema;

    @Override
    public String[][] convert(int width, int height, int[][] mas, TexColorSchema cvet) {
//        TexColorSchema cvet = new ColorSchema();
        String[][] maas = new String[width][height];
        for (int a = 0; a < width; a++) {
            for (int b = 0; b < height; b++) {
                int f = mas[a][b];
                char r;
                r = Objects.requireNonNullElse(schema, cvet).convert(f);
//                if (schema == null) {
//                    r = cvet.convert(f);
//                } else {
//                    r = schema.convert(f);
//                }
                String sr = String.valueOf(r) + r;
                maas[a][b] = sr;
            }
        }
        return maas;
    }

    @Override
    public void setTextColorSchema(TexColorSchema schema) {
        char[] sim = {'#', '$', '@', '%', '*', '+', '-', '"'};
        try {
            for (int u = 0; u < 256; u++) {
                char r = schema.convert(u);
                int g = u / 32;
                if (sim[g] != r) {
                    this.schema = null;
                    System.out.println("Ошибка1 логики в конвекторе schema");
                    return;
                }
            }
            this.schema = schema;
        }catch (ArrayIndexOutOfBoundsException ignored){
            System.out.println("Отсутствует логика в конвекторе schema");
        }
    }
}
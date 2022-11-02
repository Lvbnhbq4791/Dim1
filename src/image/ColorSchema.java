package image;

public class ColorSchema implements TexColorSchema{
    public char[] sim = {'#', '$', '@', '%', '*', '+', '-', '"'};

    @Override
    public char convert(int color) {
        int n = color/32;
        return sim[n];
    }
}

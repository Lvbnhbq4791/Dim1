package image;

public class ColorSchem implements TexColorSchema{
//    TexColorSchema kolorit = new ColorSchem();

    public char[] sim = {'#', '$', '@', '%', '*', '+', '-', '"'};
    @Override
    public char convert(int color) {
        int n = color/30;
        return sim[n];
    }
}

package image;

public interface TexConver {
   String [][] convert(int width, int height, int [][] mas, TexColorSchema cvet);
   void setTextColorSchema(TexColorSchema schema);
}

package printer;
import render.Renderer;

public class PrinterWithPrefixImpl implements Printer{
	public String my_text;
	Renderer render;
	public PrinterWithPrefixImpl(Renderer my_render)
	{
		render = my_render;
		my_text = "";
	}
	public void print(String rextic) {
		my_text += rextic;
		render.printout(my_text);
	}
	public void setPrefix(String prfix )
	{
		my_text = prfix + my_text;
	}
}

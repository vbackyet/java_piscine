package printer;
import render.Renderer;
import java.time.LocalDateTime;


public class PrinterWithDateTimeImpl implements Printer{
	public String my_text;
	Renderer render;
	public PrinterWithDateTimeImpl(Renderer my_render)
	{
		render = my_render;
		my_text = "";
	}
	public void print(String rextic) {
		my_text += (rextic + " " + LocalDateTime.now());

		render.printout(my_text);
	}
}


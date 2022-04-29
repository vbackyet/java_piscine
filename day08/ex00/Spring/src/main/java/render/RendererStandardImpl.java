package render;
import preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer{
	public PreProcessor preprocessor;
	public RendererStandardImpl(PreProcessor preprocessor)
	{
		this.preprocessor = preprocessor;
	}
	public void printout(String text)
	{
		System.out.println(preprocessor.set_case(text));
	}
}
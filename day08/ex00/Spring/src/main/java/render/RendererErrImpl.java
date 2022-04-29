package render;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer{
	public PreProcessor preprocessor;
	public RendererErrImpl(PreProcessor preprocessor)
	{
		this.preprocessor = preprocessor;
	}
	public void printout(String text)
	{
		System.err.println(preprocessor.set_case(text));
	}
}

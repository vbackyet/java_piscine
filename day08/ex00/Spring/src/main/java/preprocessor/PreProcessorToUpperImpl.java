package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor{
	public String set_case(String text)
	{
		return text.toUpperCase();
	}
}

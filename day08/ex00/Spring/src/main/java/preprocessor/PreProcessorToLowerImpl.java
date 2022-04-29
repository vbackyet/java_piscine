package preprocessor;

public class PreProcessorToLowerImpl implements PreProcessor{
	// public String text;
	// public PreProcessorToLowerImpl(String my_text)
	// {
	// 	text = my_text;
	// }
	public String set_case(String text)
	{
		return text.toLowerCase();
	}
}

package gg.jte.generated.precompiled;
import com.example.demo.entity.Category;
@SuppressWarnings("unchecked")
public final class JtecategoriesGenerated {
	public static final String JTE_NAME = "categories.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,1,1,1,1,1,12,12,12,13,13,13,14,14,18,18,18,1,1,1,1};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtecategoriesGenerated.class, "JtecategoriesGenerated.bin", 181,14,11,27);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Iterable<Category> categories) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (Category category : categories) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(category.getName());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Iterable<Category> categories = (Iterable<Category>)params.get("categories");
		render(jteOutput, jteHtmlInterceptor, categories);
	}
}

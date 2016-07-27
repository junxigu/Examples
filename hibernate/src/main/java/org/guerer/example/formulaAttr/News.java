package org.guerer.example.formulaAttr;

public class News {
	private Integer id;
	private String title;
	private String content;
	private String fullContent;
	
	public News() {
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	
	public void setFullContent(String fullContent) {
		this.fullContent = fullContent;
	}
	
	public String getFullContent() {
		return fullContent;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content="
				+ content + ", fullContent=" + fullContent + "]";
	}

}

package admin;

public class NoticeDTO {

	private Long id;
	private String title;
	private String writer;
	private String topExposure;
	private String content;
	private String attachments;
	private Integer views;
	private String createDatetime;
	private Integer row;
	
	public NoticeDTO() {
		
	}
	
	public NoticeDTO(Long id, String title, String writer, String topExposure, String content, String attachments,
			Integer views, String createDatetime,Integer row) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.topExposure = topExposure;
		this.content = content;
		this.attachments = attachments;
		this.views = views;
		this.createDatetime = createDatetime;
		this.row= row;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTopExposure() {
		return topExposure;
	}

	public void setTopExposure(String topExposure) {
		this.topExposure = topExposure;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "NoticeDTO [id=" + id + ", title=" + title + ", writer=" + writer + ", topExposure=" + topExposure
				+ ", content=" + content + ", attachments=" + attachments + ", views=" + views + ", createDatetime="
				+ createDatetime + ", row=" + row + "]";
	}

	
	
}

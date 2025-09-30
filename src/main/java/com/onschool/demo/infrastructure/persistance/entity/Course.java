package com.onschool.demo.infrastructure.persistance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_course</b>.
 * <p>
 * Lưu thông tin chi tiết về khóa học trong Moodle.
 * Mỗi {@link Course} có thể chứa nhiều {@link CourseModules}, {@link Enrol}, {@link CourseSections},
 * {@link CourseCompletionCriteria} và {@link CourseCompletions}, đồng thời liên kết với một {@link Context}.
 * </p>
 *
 * <ul>
 *   <li><b>category</b>: ID danh mục khóa học.</li>
 *   <li><b>sortOrder</b>: thứ tự sắp xếp khóa học.</li>
 *   <li><b>fullname</b>: tên đầy đủ của khóa học.</li>
 *   <li><b>shortname</b>: tên rút gọn của khóa học.</li>
 *   <li><b>idnumber</b>: mã định danh khóa học.</li>
 *   <li><b>summary</b>: mô tả tóm tắt khóa học.</li>
 *   <li><b>summaryformat</b>: định dạng mô tả (HTML, plain text...).</li>
 *   <li><b>format</b>: định dạng hiển thị khóa học (topics, weeks...).</li>
 *   <li><b>showgrades</b>: có hiển thị điểm hay không.</li>
 *   <li><b>startdate</b> / <b>enddate</b>: thời gian bắt đầu và kết thúc khóa học.</li>
 *   <li><b>visible</b>: trạng thái hiển thị của khóa học.</li>
 *   <li><b>groupmode</b> / <b>groupmodeforce</b>: thiết lập nhóm trong khóa học.</li>
 *   <li><b>timecreated</b> / <b>timemodified</b>: timestamp tạo và chỉnh sửa khóa học.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link CourseModules}: Danh sách các module thuộc khóa học.</li>
 *   <li>{@link Enrol}: Danh sách phương thức enrolment của khóa học.</li>
 *   <li>{@link CourseCompletionCriteria}: Danh sách tiêu chí hoàn thành khóa học.</li>
 *   <li>{@link CourseSections}: Danh sách section trong khóa học.</li>
 *   <li>{@link CourseCompletions}: Danh sách bản ghi hoàn thành của người dùng.</li>
 *   <li>{@link Context}: Ngữ cảnh liên kết với khóa học (<b>OneToOne</b>, `mappedBy = "course"`).</li>
 * </ul>
 *
 * <p>
 * Lưu ý về OneToOne với {@link Context}:
 * <br>
 * Khóa học không phải là chủ sở hữu; {@link Context} là chủ sở hữu mối quan hệ.
 * Do đó, `Course` chỉ tham chiếu ngược thông qua `mappedBy`.
 * </p>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ID danh mục khóa học. */
    private Long category;

    /** Thứ tự sắp xếp khóa học. */
    @Column(name = "sortorder")
    private Long sortOrder;

    /** Tên đầy đủ của khóa học. */
    private String fullname;

    /** Tên rút gọn của khóa học. */
    private String shortname;

    /** Mã định danh khóa học. */
    private String idnumber;

    /** Mô tả tóm tắt khóa học. */
    private String summary;

    /** Định dạng mô tả (HTML, plain text...). */
    private Integer summaryformat;

    /** Định dạng hiển thị khóa học (topics, weeks...). */
    private String format;

    /** Có hiển thị điểm hay không. */
    private Integer showgrades;

    /** Timestamp của các bản tin (news). */
    private Long newsiems;

    /** Thời gian bắt đầu khóa học. */
    private Long startdate;

    /** Thời gian kết thúc khóa học. */
    private Long enddate;

    /** Chế độ hiển thị ngày tháng tương đối. */
    private Integer relativedatesmode;

    /** Marker của khóa học. */
    private Long marker;

    /** Kích thước tối đa file tải lên (bytes). */
    private Long maxbytes;

    /** Quyền legacy files. */
    private Integer legacyfiles;

    /** Có hiển thị báo cáo hay không. */
    private Integer showreports;

    /** Trạng thái hiển thị của khóa học. */
    private Integer visible;

    /** Trạng thái hiển thị trước đó. */
    private Integer visibleold;

    /** Chế độ nhóm. */
    private Integer groupmode;

    /** Ép buộc chế độ nhóm hay không. */
    private Integer groupmodeforce;

    /** ID nhóm mặc định. */
    private Long defaultgroupingid;

    /** Ngôn ngữ khóa học. */
    private String lang;

    /** Loại calendar. */
    private String calendartype;

    /** Theme của khóa học. */
    private String theme;

    /** Timestamp tạo khóa học. */
    private Long timecreated;

    /** Timestamp chỉnh sửa khóa học. */
    private Long timemodified;

    /** Có yêu cầu phê duyệt hay không. */
    private Integer requested;

    /** Bật theo dõi hoàn thành hay không. */
    private Integer enablecompletion;

    /** Thông báo hoàn thành hay không. */
    private Integer completionnotify;

    /** Cache revision. */
    private Long cacherev;

    /** Danh sách các module thuộc khóa học. */
    @OneToMany(mappedBy = "courseEntity")
    private List<CourseModules> courseModulesList;

    /** Danh sách phương thức enrolment của khóa học. */
    @OneToMany(mappedBy = "course")
    private List<Enrol> enrols;

    /** Danh sách tiêu chí hoàn thành khóa học. */
    @OneToMany(mappedBy = "courseEntity")
    private List<CourseCompletionCriteria> courseCompletionCriteria;

    /** Danh sách section trong khóa học. */
    @OneToMany(mappedBy = "courseEntity")
    private List<CourseSections> courseSections;

    /** Danh sách bản ghi hoàn thành của người dùng. */
    @OneToMany(mappedBy = "courseEntity")
    private List<CourseCompletions> courseCompletions;

    /** Ngữ cảnh liên kết với khóa học (OneToOne, mappedBy). */
    @OneToOne(mappedBy = "course")
    private Context context;
}

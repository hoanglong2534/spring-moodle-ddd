package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "course_modules")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseModules {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ID instance cụ thể của module. */
    private Long instance;

    /** Mã định danh tuỳ chỉnh. */
    private String idnumber;

    /** Timestamp khi module được thêm. */
    private Long added;

    /** Điểm số liên quan đến module. */
    private Integer score;

    /** Cấp độ thụt lề module trong khóa học. */
    private Long indent;

    /** Trạng thái hiển thị của module. */
    private Integer visible;

    /** Trạng thái hiển thị trước đó. */
    private Integer visibleold;

    /** Trạng thái hiển thị trên trang khóa học. */
    private Integer visibleoncoursepage;

    /** Chế độ nhóm của module. */
    private Integer groupmode;

    /** ID grouping liên quan. */
    private Long groupingid;

    /** Trạng thái hoàn thành module. */
    private Integer completion;

    /** ID mục đánh giá hoàn thành. */
    private Long completiongradeitemnumber;

    /** Hoàn thành dựa trên lượt xem. */
    private Integer completionview;

    /** Thời gian dự kiến hoàn thành. */
    private Long completionexpected;

    /** Hiển thị mô tả hay không. */
    private Integer showdescription;

    /** Quy tắc khả dụng của module. */
    private String availability;

    /** Cờ đánh dấu module đang bị xóa. */
    private Integer deletioninprogress;

    /** Assignment liên kết với module. */
    @OneToOne(mappedBy = "courseModules")
    @JsonIgnore
    private Assign assign;

    /** Quiz liên kết với module. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance", referencedColumnName = "id", insertable = false, updatable = false)
    private Quiz quiz;

    /** Label liên kết với module. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Label label;

    /** URL liên kết với module. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance", referencedColumnName = "id", insertable = false, updatable = false)
    private Url url;

    /** Danh sách hoàn thành liên quan đến module. */
    @OneToMany(mappedBy = "courseModules")
    @JsonIgnore
    private Set<CourseModulesCompletion> courseModulesCompletions;

    /** Loại module liên kết.   */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module")
    @JsonIgnore
    private Modules modules;

    /** Khóa học chứa module. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    @JsonIgnore
    private Course courseEntity;

    /** Section chứa module. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section")
    @JsonIgnore
    private CourseSections courseSections;

    /** Ngữ cảnh liên quan đến module. */
    @OneToOne(mappedBy = "module")
    @JsonIgnore
    private Context context;
}

package com.onschool.demo.infrastructure.persistance.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_course_categories</b>.
 * <p>
 * Lưu thông tin về danh mục khóa học trong Moodle.
 * Mỗi {@link CourseCategories} có thể liên kết với một {@link Context}.
 * </p>
 *
 * <ul>
 *   <li><b>name</b>: tên danh mục khóa học.</li>
 *   <li><b>idnumber</b>: mã định danh danh mục khóa học.</li>
 *   <li><b>description</b>: mô tả chi tiết danh mục.</li>
 *   <li><b>descriptionformat</b>: định dạng mô tả (HTML, plain text...).</li>
 *   <li><b>parent</b>: ID danh mục cha nếu có.</li>
 *   <li><b>sortorder</b>: thứ tự sắp xếp danh mục.</li>
 *   <li><b>coursecount</b>: số lượng khóa học trong danh mục.</li>
 *   <li><b>visible</b>: trạng thái hiển thị danh mục (1 = visible, 0 = hidden).</li>
 *   <li><b>visibleold</b>: trạng thái hiển thị trước đó.</li>
 *   <li><b>timemodified</b>: timestamp lần chỉnh sửa cuối cùng.</li>
 *   <li><b>depth</b>: độ sâu của danh mục trong cây phân cấp.</li>
 *   <li><b>path</b>: đường dẫn phân cấp danh mục (ví dụ: /1/3/5).</li>
 *   <li><b>theme</b>: theme áp dụng cho danh mục.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link Context}: Ngữ cảnh liên kết với danh mục (<b>OneToOne</b>, `mappedBy = "categories"`).</li>
 * </ul>
 *
 * <p>
 * Lưu ý về OneToOne với {@link Context}:
 * <br>
 * Danh mục không phải là chủ sở hữu; {@link Context} là chủ sở hữu mối quan hệ.
 * Do đó, `CourseCategories` chỉ tham chiếu ngược thông qua `mappedBy`.
 * </p>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "course_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseCategories {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Tên danh mục khóa học. */
    private String name;

    /** Mã định danh danh mục khóa học. */
    private String idnumber;

    /** Mô tả chi tiết danh mục. */
    private String description;

    /** Định dạng mô tả (HTML, plain text...). */
    private Integer descriptionformat;

    /** ID danh mục cha nếu có. */
    private Long parent;

    /** Thứ tự sắp xếp danh mục. */
    private Long sortorder;

    /** Số lượng khóa học trong danh mục. */
    private Long coursecount;

    /** Trạng thái hiển thị danh mục (1 = visible, 0 = hidden). */
    private Integer visible;

    /** Trạng thái hiển thị trước đó. */
    private Integer visibleold;

    /** Timestamp lần chỉnh sửa cuối cùng. */
    private Long timemodified;

    /** Độ sâu của danh mục trong cây phân cấp. */
    private Long depth;

    /** Đường dẫn phân cấp danh mục (ví dụ: /1/3/5). */
    private String path;

    /** Theme áp dụng cho danh mục. */
    private Long theme;

    /** Ngữ cảnh liên kết với danh mục (OneToOne, mappedBy). */
    @OneToOne(mappedBy = "categories")
    private Context context;
}

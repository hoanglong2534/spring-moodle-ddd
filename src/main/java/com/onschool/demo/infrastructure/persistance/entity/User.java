package com.onschool.demo.infrastructure.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_user</b>.
 * <p>
 * Lưu thông tin chi tiết về người dùng trong Moodle.
 * Mỗi {@link User} có thể tham gia các khóa học, thực hiện các quiz, hoàn thành module, nhận role, và liên kết với một {@link Context}.
 * </p>
 *
 * <ul>
 *   <li><b>auth</b>: phương thức xác thực (manual, ldap...).</li>
 *   <li><b>confirmed</b>: trạng thái xác nhận tài khoản (0 = chưa, 1 = đã).</li>
 *   <li><b>deleted</b>: trạng thái xóa tài khoản (0 = không, 1 = đã xóa).</li>
 *   <li><b>suspended</b>: trạng thái tạm khóa tài khoản.</li>
 *   <li><b>username</b>, <b>password</b>: thông tin đăng nhập.</li>
 *   <li><b>firstname</b>, <b>lastname</b>, <b>email</b>: thông tin cá nhân cơ bản.</li>
 *   <li><b>timecreated</b>, <b>timemodified</b>: timestamp tạo và chỉnh sửa người dùng.</li>
 *   <li><b>...các trường khác</b>: thông tin liên hệ, ngôn ngữ, theme, timezone, mô tả...</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link QuizAttempts}: Danh sách các lần attempt quiz của người dùng.</li>
 *   <li>{@link CourseModulesCompletion}: Danh sách tiến trình hoàn thành module của người dùng.</li>
 *   <li>{@link UserEnrolments}: Danh sách phương thức enrolment của người dùng.</li>
 *   <li>{@link CourseCompletions}: Danh sách khóa học mà người dùng đã hoàn thành.</li>
 *   <li>{@link RoleAssignments}: Danh sách role assignments của người dùng.</li>
 *   <li>{@link Context}: Ngữ cảnh liên kết với người dùng (<b>OneToOne</b>, `mappedBy = "user"`).</li>
 * </ul>
 *
 * <p>
 * Lưu ý về OneToOne với {@link Context}:
 * <br>
 * User không phải là chủ sở hữu; {@link Context} là chủ sở hữu mối quan hệ.
 * Do đó, `User` chỉ tham chiếu ngược thông qua `mappedBy`.
 * </p>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Phương thức xác thực (manual, ldap...). */
    private String auth;

    /** Trạng thái xác nhận tài khoản (0 = chưa, 1 = đã). */
    private Integer confirmed;

    /** Đồng ý chính sách bảo mật hay chưa. */
    private Integer policyagreed;

    /** Trạng thái xóa tài khoản (0 = không, 1 = đã xóa). */
    private Integer deleted;

    /** Trạng thái tạm khóa tài khoản. */
    private Integer suspended;

    /** ID máy chủ MNet. */
    private Long mnethostid;

    /** Tên đăng nhập. */
    @Column(name = "username")
    private String username;

    /** Mật khẩu. */
    @Column(name = "password")
    private String password;

    /** Mã định danh người dùng. */
    private String idnumber;

    /** Họ của người dùng. */
    @Column(name = "firstname")
    private String firstname;

    /** Tên của người dùng. */
    @Column(name = "lastname")
    private String lastname;

    /** Email người dùng. */
    private String email;

    /** Các trường khác (icq, skype, phone, institution...) */
    private Integer emailstop;
    private String icq;
    private String skype;
    private String yahoo;
    private String aim;
    private String msn;
    private String phone1;
    private String phone2;
    private String institution;
    private String department;
    private String address;
    private String city;
    private String country;
    private String lang;
    private String calendartype;
    private String theme;
    private String timezone;
    private Long firstaccess;
    private Long lastaccess;
    private Long lastlogin;
    private Long currentlogin;
    private String lastip;
    private String secret;
    private Long picture;
    private String url;

    /** Mô tả người dùng (LONGTEXT). */
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private Integer descriptionformat;
    private Integer mailformat;
    private Integer maildigest;
    private Integer maildisplay;
    private Integer autosubscribe;
    private Integer trackforums;
    private Long timecreated;
    private Long timemodified;
    private Long trustbitmask;
    private String imagealt;
    private String lastnamephonetic;
    private String firstnamephonetic;
    private String middlename;
    private String alternatename;
    private String moodlenetprofile;

    /** Danh sách các lần attempt quiz của người dùng. */
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<QuizAttempts> quizAttemptsList;

    /** Danh sách tiến trình hoàn thành module của người dùng. */
    @OneToMany(mappedBy = "user")
    private List<CourseModulesCompletion> courseModulesCompletions;

    /** Danh sách phương thức enrolment của người dùng. */
    @OneToMany(mappedBy = "user")
    private List<UserEnrolments> userEnrolmentsl;

    /** Danh sách khóa học mà người dùng đã hoàn thành. */
    @OneToMany(mappedBy = "user")
    private List<CourseCompletions> courseCompletions;

    /** Danh sách role assignments của người dùng. */
    @OneToMany(mappedBy = "user")
    private List<RoleAssignments> roleAssignmentsList;

    /** Ngữ cảnh liên kết với người dùng (OneToOne, mappedBy). */
    @OneToOne(mappedBy = "user")
    private Context context;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

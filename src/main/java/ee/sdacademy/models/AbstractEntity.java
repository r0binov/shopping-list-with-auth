package ee.sdacademy.models;

import jakarta.persistence.*;

@MappedSuperclass
public class AbstractEntity {

    private static final int ODD_PRIME = 31;

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
        return id;
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : ODD_PRIME * getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getId() == null || obj == null || !(getClass().equals(obj.getClass()))) {
            return false;
        }

        return getId().equals(((AbstractEntity) obj).getId());
    }
}

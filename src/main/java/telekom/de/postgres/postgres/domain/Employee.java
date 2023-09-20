package telekom.de.postgres.postgres.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "json_test")
@TypeDef(name = "jsontype", typeClass = JsonType.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productOrderId;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publicIdentifier;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String externalId;

    @Type(type = "jsontype")
    @Column(columnDefinition = "jsonb", name = "boi_data")
    private Object backendOrderIdData;

    public Employee() {

    }

    public Employee(String productOrderId,Object backendOrderIdData) {
        this.productOrderId = productOrderId;
        this.backendOrderIdData = backendOrderIdData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicIdentifier() {
        return publicIdentifier;
    }

    public void setPublicIdentifier(String publicIdentifier) {
        this.publicIdentifier = publicIdentifier;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Object getBackendOrderIdData() {
        return backendOrderIdData;
    }

    public void setBackendOrderIdData(Object backendOrderIdData) {
        this.backendOrderIdData = backendOrderIdData;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

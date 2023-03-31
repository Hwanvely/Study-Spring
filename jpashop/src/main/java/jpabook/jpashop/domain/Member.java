package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //Embedded 나 Embeddable 둘중 하나만 있어도 동작은 한다.
    private Address address;

    @OneToMany(mappedBy = "member") //상대방이 주인인 것을 JPA에게 알려줌
    private List<Order> orders = new ArrayList<>();
}

package practice.springboot.demo.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars {
    private Long id;
    private String name;
    private String model;
    private int speed;
}

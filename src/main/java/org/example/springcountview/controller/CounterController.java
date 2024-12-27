package org.example.springcountview.controller;


import org.example.springcountview.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.swing.plaf.IconUIResource;

//lưu doi tuong trong session thay vi pham vi request
@Controller
@SessionAttributes("counter")
//Không sử dụng session (@SessionAttributes): Đối tượng counter chỉ tồn tại trong phạm vi mỗi request. Mỗi lần tải lại trang hoặc thực hiện yêu cầu mới, đối tượng sẽ được tạo lại và giá trị bộ đếm sẽ bị reset.
public class CounterController {
//    Giám sát tất cả các phương thức trong lớp controller để xem thuộc tính "counter" có được thêm vào Model hay không.
//    Nếu có, Spring sẽ lưu trữ thuộc tính "counter" vào session thay vì chỉ giữ nó trong phạm vi request.

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }
//    Khi phương thức setUpCounter() được gọi, giá trị trả về (Counter) sẽ được tự động thêm vào model.

  @GetMapping("/count")
    public String get(@ModelAttribute("counter") Counter counter) {
      counter.increment();
      return "/index";
    }

//    pring sẽ tìm kiếm trong model (hoặc session) đối tượng có tên "counter". Nếu không tìm thấy, Spring sẽ gọi phương thức setUpCounter() để tạo đối tượng mới và đưa vào model.
}

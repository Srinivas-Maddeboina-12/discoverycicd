    package com.customapp.application.service;

    import com.customapp.application.dto.AddressDto;
    import com.customapp.application.dto.EmployeeDto;
    import com.customapp.application.dto.UserDto;
    import com.customapp.application.model.Address;
    import com.customapp.application.model.Employee;
    import com.customapp.application.model.User;
    import com.customapp.application.repository.EmployeeRepository;
    import com.customapp.application.repository.UserRepository;
    import org.springframework.stereotype.Service;
    import org.springframework.util.StringUtils;

    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class EmployeeService {

        private final EmployeeRepository employeeRepository;

        private final UserRepository userRepository;

        public EmployeeService(EmployeeRepository employeeRepository, UserRepository userRepository) {
            this.employeeRepository = employeeRepository;
            this.userRepository = userRepository;
        }

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Employee addEmployee(EmployeeDto dto) {
            Employee employee = new Employee();
            employee.setFirstName(dto.getFirstName());
            employee.setLastName(dto.getLastName());
            employee.setEmail(dto.getEmail());
            UserDto userDto = dto.getUser();
            if (userDto != null) {
                User user;
                if (userDto.getId() != null) {
                    user = userRepository.findById(userDto.getId())
                            .orElseThrow(() -> new RuntimeException("User not found with id: " + userDto.getId()));
                    if (StringUtils.hasText(userDto.getUsername())) {
                        user.setUsername(userDto.getUsername());
                    }
                    if (StringUtils.hasText(userDto.getPassword())) {
                        user.setPassword(userDto.getPassword());
                    }
                } else {
                    user = new User();
                    user.setUsername(userDto.getUsername());
                    user.setPassword(userDto.getPassword());
                }
                employee.setUser(user);
            }
            List<AddressDto> addressDtos = dto.getAddressList();
            List<Address> addresses = new ArrayList<>();
            if (addressDtos != null) {
                for (AddressDto addressDto : addressDtos) {
                    Address address = new Address();
                    address.setAddressType(addressDto.getAddressType());
                    address.setStreet(addressDto.getStreet());
                    address.setCity(addressDto.getCity());
                    address.setEmployee(employee);
                    addresses.add(address);
                }
                employee.setAddresses(addresses);
            }
            return employeeRepository.save(employee);

        }
    }

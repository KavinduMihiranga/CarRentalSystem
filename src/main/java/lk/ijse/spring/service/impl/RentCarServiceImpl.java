package lk.ijse.spring.service.impl;

import lk.ijse.spring.entity.RentCar_PK;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.entity.RentDetails;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.RentDetailsRepo;
import lk.ijse.spring.repo.RentRepo;
import lk.ijse.spring.service.RentCarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentCarServiceImpl implements RentCarService {
    @Autowired
    private RentRepo rentRepo;

    @Autowired
    private RentDetailsRepo rentDetailsRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void book_rent(RentDTO dto) {
        Rent rent = mapper.map(dto, Rent.class);
        if (!rentRepo.existsById(dto.getRid())) {
            rentRepo.save(rent);
            System.out.println(rent);

            if (dto.getRentDetails().size() < 1) throw new RuntimeException("No items added for the Rent..!");

            //update the item
            for (RentDetails rentDetails : rent.getRentDetails()) {
                Car car = carRepo.findById(rentDetails.getCId()).get();
                car.setStatus(rentDetails.getStatus());
                carRepo.save(car);
            }

        } else {
            throw new RuntimeException("Purchase Rent Failed..!, Rent ID " + dto.getRid() + " Already Exist.!");
        }
    }

    @Override
    public void delete_rent(String rid) {
        if (rentRepo.existsById(rid)) {
            rentRepo.deleteById(rid);
        } else {
            throw new RuntimeException("Delete Rent Failed..!, Rent ID " + rid + " Not Exist..!");
        }
    }

    @Override
    public void update_rent(RentDTO dto) {
        if (rentRepo.existsById(dto.getRid())) {

            Rent rent = mapper.map(dto, Rent.class);
            if (dto.getRentDetails().size() < 1) throw new RuntimeException("No items added for the rent..!");

            for (RentDetails rd : rent.getRentDetails()) {
                Car car = carRepo.findById(rd.getCId()).get();
                RentDetails previous = rentDetailsRepo.findById(new RentCar_PK(rd.getRId(), rd.getCId())).get();

                carRepo.save(car);
            }
            //then delete the old order
            rentRepo.deleteById(dto.getRid());
            //finally update the new order
            rentRepo.save(rent);
        } else {
            throw new RuntimeException("Update Rent Failed..!, Rent ID " + dto.getRid() + " Not Exist.!");
        }
    }

    @Override
    public RentDTO search_rent(String rid) {
        if (rentRepo.existsById(rid)) {
            return mapper.map(rentRepo.findById(rid), RentDTO.class);
        } else {
            throw new RuntimeException("Search Rent Failed..!, Rent ID " + rid + " Not Exist.!");
        }
    }

    @Override
    public List<RentDTO> get_all_rents() {
        return mapper.map(rentRepo.findAll(), new TypeToken<List<RentDTO>>() {
        }.getType());
    }
}


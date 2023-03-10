package spbpu.vrk.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import spbpu.vrk.clinic.entity.Price;
import spbpu.vrk.clinic.entity.TypeOfMedicalCare;
import spbpu.vrk.clinic.repository.PriceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PriceService {

    private PriceRepository priceRepository;

    public Map<TypeOfMedicalCare, List<Price>> findAllPricesWithTypeByKeyWord(String keyWord) {
        List<Price> prices = priceRepository.findAll();
        Map<TypeOfMedicalCare, List<Price>> mapFromDb = prices.stream()
                .collect(Collectors.groupingBy(price -> price.getMedicalCare().getTypeOfMedicalCare()));
        if (StringUtils.isEmpty(keyWord)) {
            return mapFromDb;
        }
        Map<TypeOfMedicalCare, List<Price>> resultMap = new HashMap<>();
        for (Map.Entry<TypeOfMedicalCare, List<Price>> temp : mapFromDb.entrySet()) {
            if (temp.getKey().getLabel().toLowerCase().contains(keyWord)) {
                resultMap.put(temp.getKey(), temp.getValue());
            } else {
                List<Price> collectList = temp.getValue().stream().filter(e -> e.getMedicalCare().getLabel().toLowerCase().contains(keyWord)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(collectList)) {
                    resultMap.put(temp.getKey(), collectList);
                }
            }
        }
        return resultMap;
    }
}

package com.company.utility;

import com.company.models.AbstractCsvEntity;
import java.util.List;
import java.util.Optional;

public class SearchUtility {
    public static <T extends AbstractCsvEntity> Optional<T> findElementById(List<T> obj, int id) {
        return obj.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }
}

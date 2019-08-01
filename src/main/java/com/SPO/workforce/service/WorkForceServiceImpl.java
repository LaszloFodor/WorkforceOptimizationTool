package com.SPO.workforce.service;

import com.SPO.workforce.entity.Cleaners;
import com.SPO.workforce.entity.Place;
import com.SPO.workforce.exception.CleanerCapacityException;
import com.SPO.workforce.exception.RoomSizeNotAppropriate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkForceServiceImpl implements WorkForceService {

    @Override
    public List<Cleaners> calculateCleaners(Place place) throws RoomSizeNotAppropriate, CleanerCapacityException {
        List<Cleaners> finalCleaners = new ArrayList<>();

        if (place.getJuniorCleanerCapacity() < 0 || place.getSeniorCleanerCapacity() < 0 ||
                (place.getJuniorCleanerCapacity() < 1 || place.getSeniorCleanerCapacity() < 1)) {
            throw new CleanerCapacityException();
        }

        if (place.getRooms() == null || place.getRooms().size() == 0) {
            throw new RoomSizeNotAppropriate();
        }

        for (int i = 0; i < place.getRooms().size(); i++) {
            if (place.getRooms().get(i) > 100) {
                throw new RoomSizeNotAppropriate();
            }

            int senior = 0;
            int junior = 0;
            int sizeOfRoom = place.getRooms().get(i);

            if (sizeOfRoom < place.getSeniorCleanerCapacity()) {
                senior++;
            } else {
                int remaining = sizeOfRoom - place.getSeniorCleanerCapacity();
                senior++;
                while (remaining > 0) {

                    int seniorCleaner = remaining / place.getSeniorCleanerCapacity();
                    int juniorCleaner = remaining / place.getJuniorCleanerCapacity();

                    if (remaining % place.getSeniorCleanerCapacity() == 0) {
                        remaining -= place.getSeniorCleanerCapacity();
                        senior++;
                    } else if (remaining % place.getJuniorCleanerCapacity() == 0) {
                        remaining -= place.getJuniorCleanerCapacity();
                        junior++;
                    } else if (seniorCleaner < juniorCleaner) {
                        remaining -= place.getSeniorCleanerCapacity();
                        senior++;
                    } else if (seniorCleaner > juniorCleaner) {
                        remaining -= place.getJuniorCleanerCapacity();
                        junior++;
                    } else {
                        int srJrDiff = Math.abs(remaining % place.getSeniorCleanerCapacity() -
                                remaining % place.getJuniorCleanerCapacity());
                        int jrSrDiff = Math.abs(remaining % place.getJuniorCleanerCapacity() -
                                remaining % place.getSeniorCleanerCapacity());
                        if ( srJrDiff < jrSrDiff) {
                            remaining -= place.getSeniorCleanerCapacity();
                            senior++;
                        } else {
                            remaining -= place.getJuniorCleanerCapacity();
                            junior++;
                        }
                    }
                }
            }
            finalCleaners.add(new Cleaners(senior, junior));
        }
        return finalCleaners;
    }

}

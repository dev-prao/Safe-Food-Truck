package com.safefoodtruck.sft.store.service;

import com.safefoodtruck.sft.store.exception.StoreNotFoundException;
import com.safefoodtruck.sft.store.domain.Store;
import com.safefoodtruck.sft.store.dto.request.StoreRegistRequestDto;
import com.safefoodtruck.sft.store.dto.response.StoreInfoDto;
import com.safefoodtruck.sft.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public StoreInfoDto getStoreInfo(int storeId) {
        Store store = storeRepository.findById(storeId)
            .orElseThrow(StoreNotFoundException::new);
        return StoreInfoDto.fromEntity(store);
    }

    @Override
    public void registStore(StoreRegistRequestDto storeRegistRequestDto) {

    }
}

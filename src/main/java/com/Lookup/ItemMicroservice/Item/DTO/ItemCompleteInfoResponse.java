package com.Lookup.ItemMicroservice.Item.DTO;

import com.Lookup.ItemMicroservice.Item.Entity.Info;
import lombok.Builder;

@Builder
public class ItemCompleteInfoResponse extends ItemBasicInfoResponse {
    private boolean inProduction;
    private Info showedInfo;
    private Info openedInfo;
}

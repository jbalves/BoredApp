package com.example.boredapi.data.network.mapper

import com.example.boredapi.data.network.dto.ActivityDto
import com.example.boredapi.data.network.responseobject.ActivityResponse
import javax.inject.Inject


class ActivityMapper @Inject constructor() : BaseMapper<ActivityDto, ActivityResponse> {
    override fun mapFromInput(input: ActivityDto): ActivityResponse {
        return ActivityResponse(
            activity = input.activity,
            availability = input.availability,
            type = input.type,
            participants = input.participants,
            price = input.price,
            accessibility = input.accessibility,
            duration = input.duration,
            kidFriendly = input.kidFriendly,
            link = input.link,
            key = input.key
        )
    }
}

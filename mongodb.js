db.getCollection('route').find(
    {
        'points.station': 18,
        'firstDeparture': {$lt: ISODate("2016-04-30T21:00:00.000Z")},
        'end': {$gt: ISODate("2016-04-04T21:00:00.000Z")}
    })
# API

## `GET: /rooms?:limit&:offset`

Returns a list of existing hotel rooms.

Request Params:

- limit: max number of rooms viewable per page
- offset: number of rooms already viewed

Response:

```
{
    "total": 40,
    "limit": 10,
    "offset": 5,
    "rooms": [
        {
            "id": 1,
            "name": "Standard Doppelzimmer",
            "description": "Großes helles Zimmer mit westseitigem Balkon...",
            "characteristics": [
                {
                    "id": 1,
                    "name": "TV"
                },
                {
                    "id": 2,
                    "name": "Balkon"
                },
                ...
            ],
            "images": [
                {
                    "id": 1,
                    "name": "fse4s45r5s44r3d.jpg"
                },
                {
                    "id": 2,
                    "name": "sldkfjlsrefjiosufh.jpg"
                },
                ...
            ],
        },
        ...
    ]
}
```

## `GET: /rooms/:id`

Returns details of a specific room.

Request Params:

- id: identifier of the specific room

Response:

```
{
    "id": 1,
    "name": "Standard Doppelzimmer",
    "description": "Großes helles Zimmer mit westseitigem Balkon...",
    "characteristics": [
        {
            "id": 1,
            "name": "TV"
        },
        {
            "id": 2,
            "name": "Balkon"
        },
        ...
    ],
    "images": [
        {
            "id": 1,
            "name": "fse4s45r5s44r3d.jpg"
        },
        {
            "id": 2,
            "name": "sldkfjlsrefjiosufh.jpg"
        },
        ...
    ],
}
```

## `GET: /rooms/:id/availability?:startDate&:endDate`

Checks if a room is available for a given date range.

Request Params:

- id: identifies a specific room
- startDate: Checkin date in the format: YYYY-MM-DD
- endDate: Checkout date in the format: YYYY-MM-DD

Response:

```
{
    "available": true
}
```

## `POST: /booking`

Books a room for a specified date range for a specific customer.

Request:

```
{
    "id": 1,
    "startDate": "YYYY-MM-DD",
    "endDate": "YYYY-MM-DD",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@doe.com",
    "breakfast": true
}
```

Response:

```
{
    "bookingNumber": "23438232",
    "startDate": "YYYY-MM-DD",
    "endDate": "YYYY-MM-DD",
    "room":
        {
            "id": 1,
            "name": "Standard Doppelzimmer",
            "description": "Großes helles Zimmer mit westseitigem Balkon...",
            "characteristics": [
                {
                    "id": 1,
                    "name": "TV"
                },
                {
                    "id": 2,
                    "name": "Balkon"
                },
                ...
            ],
            "images": [
                {
                    "id": 1,
                    "name": "fse4s45r5s44r3d.jpg"
                },
                {
                    "id": 2,
                    "name": "sldkfjlsrefjiosufh.jpg"
                },
                ...
            ],
        },
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@doe.com",
    "breakfast": true
}
```

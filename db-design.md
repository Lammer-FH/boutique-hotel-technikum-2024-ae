# DB Design

## Rooms

> A physical room

| Column      | Type         | Null | Default       | Description           |
| ----------- | ------------ | ---- | ------------- | --------------------- |
| RoomId      | Int          | no   | autoincrement | PK                    |
| Name        | VarChar(265) | no   | ""            | name of a room        |
| Description | VarChar(265) | no   | ""            | description of a room |

## RoomImages

> An image of a room

| Column      | Type         | Null | Default       | Description                                         |
| ----------- | ------------ | ---- | ------------- | --------------------------------------------------- |
| RoomImageId | Int          | no   | autoincrement | PK                                                  |
| RoomId      | Int          | no   |               | FK Rooms.RoomId                                     |
| Filename    | VarChar(265) | no   | ""            | name of the file                                    |
| IsAnchor    | TinyInt      | no   | 0             | 0 .. standard image<br/>1 .. image shown in preview |

## Characteristics

> A characteristic a room may have

| Column           | Type        | Null | Default       | Description                        |
| ---------------- | ----------- | ---- | ------------- | ---------------------------------- |
| CharacteristicId | Int         | no   | autoincrement | PK                                 |
| Name             | VarChar(64) | no   |               | Unique                             |
| Icon             | VarChar(64) | no   |               | Iconify Icon string (library:icon) |

## RoomToCharacteristics

> Assignment of specific characteristics to a room

| Column           | Type | Nullable | Default | Description                             |
| ---------------- | ---- | -------- | ------- | --------------------------------------- |
| RoomId           | Int  | no       |         | PK1 FK Rooms.RoomId                     |
| CharacteristicId | Int  | no       |         | PK2 FK Characteristics.CharacteristicId |

## Guests

> A guest

| Column    | Type         | Nullable | Default       | Description               |
| --------- | ------------ | -------- | ------------- | ------------------------- |
| GuestId   | Int          | no       | autoincrement | PK                        |
| FirstName | VarChar(64)  | no       |               | firstname of guest        |
| LastName  | VarChar(64)  | no       |               | lastname of guest         |
| EMail     | VarChar(265) | no       |               | constraint: E-Mail format |

## Bookings

> A booking

| Column        | Type        | Nullable | Default       | Description                                                 |
| ------------- | ----------- | -------- | ------------- | ----------------------------------------------------------- |
| BookingId     | Int         | no       | autoincrement | PK                                                          |
| BookingNumber | VarChar(64) | no       |               | UniqueKey, number of a booking for communication with guest |
| StartDate     | Date        | no       |               | start of booking                                            |
| EndDate       | Date        | no       |               | end of booking (constraint must be after StartDate)         |
| BreakFast     | TinyInt     | no       | 0             | 0 .. no breakfast wanted<br/>1 .. breakfast wanted          |

## GuestToBookings

> Assignment of guests to bookings

| Column    | Type | Nullable | Default | Description               |
| --------- | ---- | -------- | ------- | ------------------------- |
| BookingId | Int  | no       |         | PK1 FK Bookings.BookingId |
| GuestId   | Int  | no       |         | PK2 FK Guests.GuestId     |

## BookingToRooms

> Assignment of a booking to the booked rooms

| Column    | Type | Nullable | Default | Description               |
| --------- | ---- | -------- | ------- | ------------------------- |
| BookingId | Int  | no       |         | PK1 FK Bookings.BookingId |
| RoomId    | Int  | no       |         | PK2 FK Rooms.RoomId       |

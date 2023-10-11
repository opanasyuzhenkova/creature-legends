# Video Game Classes Project

---------

Репозиторий содержит реализацию классов для видеоигры "Creature Legends"

## Описание классов

### `Creature`

Базовый класс для всех существ в игре.

Атрибуты:

- `name` - имя существа.
- `attack` - уровень атаки (1-30).
- `defense` - уровень защиты (1-30).
- `maxHealth` - максимальное здоровье (> 0).
- `health` - текущее здоровье (0-N).
- `damageMin` - минимальный урон.
- `damageMax` - максимальный урон.

### `Player`

Класс `Player` наследуется от класса `Creature` и представляет игрока. Он имеет дополнительные атрибуты:

- `healCount` - количество восстановлений здоровья (до 4 раз).
- `level` - уровень игрока.

Класс `Player` также имеет методы для регенерации `heal` и повышения уровня `gainLevel`.

### `Monster`

Класс `Monster` также наследуется от класса `Creature` и представляет монстра. Имеет дополнительный атрибут:

- `monsterType` - тип монстра (орк, тролль, дракон, зомби; в дальнейшем может быть добавлено расширение функционала
в зависимости от особенностей каждого из типов)

### Основная функциональность

- У всех существ есть возможность атаковать друг друга. Успешность атаки и урон рассчитывается в 
соответствии с правилами игры.

- Игрок может "лечить" себя до 4 раз на 30% от максимального здоровья.

- Игрок и монстр могут получать урон и умирать при достижении здоровья равного 0.

## Примеры игровых процессов

**Пример 1. Победа игрока**

```text
> Task :compileJava
> Task :processResources NO-SOURCE
> Task :classes

> Task :Main.main()
Player: [name=Olya, maxHealth=50, health=30, defense=15, attack=30, damageMin=20, damageMax=30] , level=5] is created!
Monster: [name=Godzilla, maxHealth=50, health=15, defense=20, attack=10, damageMin=10, damageMax=35] MonsterType=ORC] is created!
Olya is attacking!
Attack Modifier = 11
Dice value= 1
Bad shot!
Dice value= 6
Successful hit! Damage: 29
Godzilla's health = 0
---------------------
Olya's health: 30
Godzilla health: 0
---------------------
Player Olya wins!
Monster Godzilla is dead!
```

Игрок побеждает монстра в первый ход. Модификатор атаки N = 11, второй бросок 
"игральной кости" показал 6, что считается успешным ударом, наносимый урон = 29, что на 9 
больше здоровья монстра. Удар нанесен, монстр мертв. Ольга победила.


**Пример 2. Победа монстра**

```text

> Task :Main.main()
Player: [name=Olya, maxHealth=50, health=30, defense=15, attack=20, damageMin=20, damageMax=30] , level=5] is created!
Monster: [name=Godzilla, maxHealth=50, health=30, defense=30, attack=30, damageMin=30, damageMax=35] MonsterType=ORC] is created!
Olya is attacking!
Attack Modifier = 1
Dice value= 4
Bad shot!
---------------------
Olya's health: 30
Godzilla health: 30
---------------------
Godzilla is attacking!
Attack Modifier = 16
Dice value= 3
Bad shot!
Dice value= 5
Successful hit! Damage: 30
Olya's health = 0
Healing #1: Recovered 11 health.
---------------------
Olya's health: 11
Godzilla health: 30
---------------------
Olya is attacking!
Attack Modifier = 1
Dice value= 4
Bad shot!
---------------------
Olya's health: 11
Godzilla health: 30
---------------------
Godzilla is attacking!
Attack Modifier = 16
Dice value= 1
Bad shot!
Dice value= 5
Successful hit! Damage: 34
Olya's health = 0
Healing #2: Recovered 7 health.
---------------------
Olya's health: 7
Godzilla health: 30
---------------------
Olya is attacking!
Attack Modifier = 1
Dice value= 5
Successful hit! Damage: 23
Godzilla's health = 7
---------------------
Olya's health: 7
Godzilla health: 7
---------------------
Godzilla is attacking!
Attack Modifier = 16
Dice value= 2
Bad shot!
Dice value= 4
Bad shot!
Dice value= 5
Successful hit! Damage: 33
Olya's health = 0
Healing #3: Recovered 13 health.
---------------------
Olya's health: 13
Godzilla health: 7
---------------------
Olya is attacking!
Attack Modifier = 1
Dice value= 1
Bad shot!
---------------------
Olya's health: 13
Godzilla health: 7
---------------------
Godzilla is attacking!
Attack Modifier = 16
Dice value= 6
Successful hit! Damage: 30
Olya's health = 0
Healing #4: Recovered 14 health.
---------------------
Olyas health: 14
Godzilla health: 7
---------------------
Olya is attacking!
Attack Modifier = 1
Dice value= 4
Bad shot!
---------------------
Olya's health: 14
Godzilla health: 7
---------------------
Godzilla is attacking!
Attack Modifier = 16
Dice value= 1
Bad shot!
Dice value= 5
Successful hit! Damage: 30
Olya's health = 0
Healing not available, 4 healings already done
---------------------
Olya's health: 0
Godzilla health: 7
---------------------
Monster Godzilla wins!
```
В данном бою монстр побеждает.
Ольга использует все 4 возможности исцеления (при достижении значения health равного 0).
Хотя не хватило совсем немного, на последнем ходе у монстра оставалось всего лишь 7 очков здоровья :)



---
title: Відтворення звуків
description: Задавалися питанням як відтворювати звукові події? Прочитайте про це тут!
authors:
  - JR1811
---

Minecraft має великий вибір звуків, з яких ви можете вибрати. Перевірте клас `SoundEvents`, щоб переглянути всі екземпляри звукових подій, наданих Mojang.

## Використання звуків у вашому моді {#using-sounds}

Під час використання звуків обов’язково запустіть метод playSound() на стороні логічного сервера!

У цьому прикладі методи useOnEntity() і useOnBlock() для спеціального інтерактивного елемента використовуються для відтворення «розміщення мідного блоку» та звуку грабіжника.

@[code lang=java transcludeWith=:::1](@/reference/latest/src/main/java/com/example/docs/item/custom/CustomSoundItem.java)

Метод playSound() використовується з об’єктом LivingEntity. Треба вказати лише SoundEvent, гучність і висоту звуку. Ви також можете використовувати метод `playSound()` з екземпляра світу, щоб отримати вищий рівень контролю.

@[code lang=java transcludeWith=:::2](@/reference/latest/src/main/java/com/example/docs/item/custom/CustomSoundItem.java)

### SoundEvent і SoundCategory {#soundevent-and-soundcategory}

SoundEvent визначає, який звук буде відтворюватися. Ви також можете [зареєструвати власні SoundEvents](./custom), щоб включити свій власний звук.

Minecraft має кілька звукових повзунків у налаштуваннях гри. Перелік `SoundCategory` використовується, щоб визначити, який повзунок регулюватиме гучність звуку.

### Гучність і висота {#volume-and-pitch}

Параметр гучності може трохи ввести в оману. У діапазоні `0.0f - 1.0f` можна змінити фактичну гучність звуку. Якщо число стає більшим за це, використовуватиметься гучність `1.0f`, і регулюється лише відстань, на якій можна почути ваш звук. Відстань блоку можна приблизно розрахувати за допомогою `volume * 16`.

Параметр висоти збільшує або зменшує значення висоти звуку, а також змінює тривалість звуку. У діапазоні `(0,5f - 1,0f)` висота і швидкість зменшуються, тоді як більші числа збільшують висоту і швидкість. Числа нижче 0,5f залишатимуться на рівні 0,5f.

---
title: Предложения по командам
description: Узнайте, как предлагать пользователям значения аргументов команд.
authors:
  - IMB11
---

Майнкрафт имеет мощную систему предложений по командам, которая используется много где, например в команде `/give`. Эта система позволяет вам предложение значения к аргументам ваших команд для пользователей, которые они могут выбрать - это отличная возможность сделать вашу команду больше удобнее и эргономичной.

## Поставщики предложений {#suggestion-providers}

`SuggestionProvider` - используется для создания списка предложений, который будет отправлен на клиент. Поставщик предложений - это функциональный интерфейс, который использует `CommandContext` и `SuggestionBuilder`, а также возвращает `Suggestions`. `SuggestionProvider` возвращает `CompletableFuture`, потому что предложения могут быть доступны не сразу.

## Использование поставщиков предложений {#using-suggestion-providers}

Чтобы использовать поставщика предложений, необходимо вызвать метод `suggests` в конструкторе аргументов. Этот метод берёт `SuggestionProvider` и возвращает модифицированный аргумент конструктора с прикрепленным поставщиком предложений.

@[code java highlight={4} transcludeWith=:::command_with_suggestions](@/reference/latest/src/main/java/com/example/docs/command/FabricDocsReferenceCommands.java)
@[code java transcludeWith=:::execute_command_with_suggestions](@/reference/latest/src/main/java/com/example/docs/command/FabricDocsReferenceCommands.java)

## Встроенные поставщики предложений {#built-in-suggestion-providers}

Несколько встроенных поставщиков предложений которые вы можете использовать:

| Поставщик предложений                     | Описание                                                 |
| ----------------------------------------- | -------------------------------------------------------- |
| `SuggestionProviders.SUMMONABLE_ENTITIES` | Предлагает всех вызываемых сущностей.    |
| `SuggestionProviders.AVAILABLE_SOUNDS`    | Предлагает все производимые звуки.       |
| `LootCommand.SUGGESTION_PROVIDER`         | Предлагает все возможные таблицы добычи. |
| `SuggestionProviders.ALL_BIOMES`          | Предлагает всевозможные биомы.           |

## Создание собственного поставщика предложений {#creating-a-custom-suggestion-provider}

Если встроенные провайдеры не удовлетворяют вашим потребностям, вы можете создать свой поставщик предложений. Для этого, вам нужно создать класс который имплементирует интерфейс `SuggestionProvider` и перезаписать метод `getSuggestions`.

Например, мы сделаем поставщик предложений предлагающий все имена игроков на сервере.

@[code java transcludeWith=:::1](@/reference/latest/src/main/java/com/example/docs/command/PlayerSuggestionProvider.java)

Для использования этого поставщика предложений, просто передадите его экземпляр в метод `.suggests` в конструктор аргументов.

@[code java highlight={4} transcludeWith=:::command_with_custom_suggestions](@/reference/latest/src/main/java/com/example/docs/command/FabricDocsReferenceCommands.java)
@[code java transcludeWith=:::execute_command_with_custom_suggestions](@/reference/latest/src/main/java/com/example/docs/command/FabricDocsReferenceCommands.java)

Очевидно, что поставщики предложений могут быть более сложными, поскольку они также могут считывать контекст команды, чтобы предоставлять предложения на основе состояния команды, например аргументов, которые уже были предоставлены.

Это может быть в виде чтения инвентаря игрока и предлагать предметы, или сущностей вокруг игрока.

package com.techyourchance.dagger2course.common.dependnecyinjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import java.lang.reflect.Field

class UnsupportedServiceException(serviceType: Class<*>?) :
    RuntimeException("Unsupported service type: ${serviceType?.name}")

class Injector(private val component: PresentationComponent) {

    fun inject(client: Any) {
        for (field in getAllFields(client)) {
            if (isAnnotatedForInjection(field)) {
                injectField(client, field)
            }
        }
    }

    private fun injectField(client: Any, field: Field) {
        val isAccessibleInitially = field.isAccessible
        field.isAccessible = true
        field.set(client, getServiceForClass(field.type))
        field.isAccessible = isAccessibleInitially
    }

    private fun getServiceForClass(type: Class<*>?): Any {
        return when (type) {
            DialogsNavigator::class.java -> component.dialogsNavigator()
            ScreenNavigator::class.java -> component.screenNavigator()
            FetchQuestionDetailsUseCase::class.java -> component.fetchQuestionDetailsUseCase()
            FetchQuestionsUseCase::class.java -> component.fetchQuestionsUseCase()
            ViewMvcFactory::class.java -> component.viewMvcFactory()
            else -> throw UnsupportedServiceException(type)
        }
    }

    private fun isAnnotatedForInjection(field: Field): Boolean {
        val fieldAnnotations = field.annotations
        for (annotation in fieldAnnotations) {
            if (annotation is Service) return true
        }
        return false
    }

    private fun getAllFields(client: Any): List<Field> {
        val fields = mutableListOf<Field>()
        var currentClass: Class<*>? = client::class.java
        while (currentClass != null && currentClass != Any::class.java) {
            fields.addAll(currentClass.declaredFields)
            currentClass = currentClass.superclass
        }
        return fields
    }
}
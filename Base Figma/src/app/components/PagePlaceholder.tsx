interface PagePlaceholderProps {
  title: string;
  description: string;
}

export function PagePlaceholder({ title, description }: PagePlaceholderProps) {
  return (
    <div className="flex items-center justify-center h-full">
      <div className="text-center">
        <h2 className="text-3xl font-semibold text-slate-900 mb-2">{title}</h2>
        <p className="text-slate-600">{description}</p>
        <div className="mt-8 p-8 bg-slate-100 rounded-xl inline-block">
          <p className="text-slate-500">Esta funcionalidad estará disponible próximamente</p>
        </div>
      </div>
    </div>
  );
}
